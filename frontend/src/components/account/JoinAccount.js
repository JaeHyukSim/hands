import React from 'react';
import Button from 'react-bootstrap/Button'
import { joinUser } from '../../actions/userAction'
import axios from 'axios'

class JoinAccount extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      userId:'',
      email: '',
      nickname:'',
      name:'',
      password:'',
      confirmPassword:'',
      phone:'',
      address:'',
      gender:'',
      description:'',
      nameCheck:'',
      nicknameCheck:'',
      emailCheck:'',
      passwordCheck:'',
      phoneCheck:'',
    }
    // this.checkName = this.checkName.bind(this)
    // this.checkEmail = this.checkEmail.bind(this)
    // this.checkPassword = this.checkPassword.bind(this)
    // this.checkNickname = this.checkNickname.bind(this)
    // this.checkPhone = this.checkPhone.bind(this)
  }

  onNameHandler = (e) => {
    this.setState({
      name: e.target.value
    })
  }
  //이름유효성
  checkName = (e) => {
    e.preventDefault();
    console.log('checkName')
    const check_Name = function(str) {
      var regNm = /^[가-힣]{1,5}/;
      return regNm.test(str) ? true : false;
    }

    const inputName = {
      name: this.state.name
    }
    if (check_Name(this.state.name) ===false) {
      alert("한글 1~5자리만 사용 가능합니다.")
    }else {
      console.log('name 통과')
      this.setState({
        nameCheck: this.state.name
      })
    }
  }

  onNicknameHandler = (e) => {
    this.setState({
      nickname: e.target.value
    })
  }

  checkNickname = (e) => {
    e.preventDefault();

    const inputNickname = {
      nickname: this.state.nickname
    }
    axios.get(`http://i4d101.p.ssafy.io:8080/auth/validate/nickname/${this.state.nickname}`)
    .then(res => {
      this.setState({
        nicknameCheck: this.state.nickname
      })
      console.log(res)
    })
    .catch(err => {
      console.error(err)
      console.log('이미 존재하는 닉네임입니다.')
    })
  }

  //이메일 인풋창 핸들링
  onEmailHandler = e => {
    this.setState({
      email:e.target.value,
      userId:e.target.value
    })
  }
  // 이메일 중복 검사
  checkEmail = (e) => {
    e.preventDefault();

    // 이메일 유효성 검사 
    const check_Email = function(str) {
      var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
      return regExp.test(str) ? true : false;
    }

    const inputEmail = {
        email: this.state.email
    }

    if (check_Email(this.state.email) === false) {
      alert("이메일 형식이 유효하지 않습니다.")
      this.setState({
        email:""
      })
    }else {
      axios(`http://i4d101.p.ssafy.io:8080/auth/validate/id/${this.state.email}`)
      .then(res => {
        this.setState({
          emailCheck: this.state.email
        })
        console.log(res)
      })
      .catch(err => {
        console.error(err)
        console.log("이미 존재하는 이메일 입니다.")
      })
      }
    }
    


  onPasswordHandler = (e) => {
    this.setState({
      password: e.target.value
    })
  }

  onConfirmPasswordHandler = (e) => {
    this.setState({
      confirmPassword: e.target.value
    })
  }

  

  onPhoneHandler = (e) => {
    this.setState({
      phone: e.target.value
    })
  }




  onAddressHandler = e => {
    this.setState({
      address: e.target.value
    })
  }

  onGenderHandler = e => {
    this.setState({
      gender: e.target.value
    })
  }

  onDescriptionHandler = e => {
    this.setState({
      description: e.target.value
    })
  }

  onSubmitHandler = (e) => {

    e.preventDefault()
    console.log('submit')


    const signupInfo = {
      userId:this.state.email,
      password: this.state.password,
      email:this.state.email,
      nickname:this.state.nickname,
      name: this.state.nameCheck,
      phone:this.state.phone,
      address:this.state.address,
      gender:this.state.gender,
      description:this.state.description,
      confirmPassword:this.state.confirmPassword
    }

   
    //비밀번호 유효성 검사(영문,숫자 혼합 6~20)
    const check_Password = function(str) {
      var reg_pwd = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
      return !reg_pwd.test(str) ? false : true;
    }

    if (check_Password(this.state.confirmPassword) === false) {
      alert("영문,숫자를 혼합하여 6~20자 이내로 작성해주세요")
      this.setState({
        password:"",
        confirmPassword:""
      })
    }else {
      if (this.state.password === this.state.confirmPassword) {
        console.log('사용가능한 비밀번호입니다.')
        this.setState((state)=>{
          return {passwordCheck: this.state.confirmPassword}
        })
        const inputPhone = {
          phone:this.state.phone
        }
        axios.get(`http://i4d101.p.ssafy.io:8080/auth/validate/phone/${inputPhone.phone}`)
        .then(res => {
          this.setState((state)=>{
            return {phoneCheck:this.state.phone}
          })
          console.log('사용가능한 전화번호입니다.')
          console.log(res)
          if (
            this.state.email &&
            this.state.name &&
            this.state.password &&
            this.state.confirmPassword &&
            this.state.email == this.state.emailCheck &&
            this.state.name == this.state.nameCheck &&
            this.state.nickname == this.state.nicknameCheck
          ) {
            console.log('checkSubmit')
            axios.post(`http://i4d101.p.ssafy.io:8080/auth/join`,JSON.stringify(signupInfo),
            {headers:{
              'Content-Type': 'application/json'
            }}
            )
            .then(res => {
              alert("가입이 정상적으로 완료되었습니다.")
              this.props.history.push('/home/login')
            })
          } else {
            alert("정보입력을 확인해주세요.")
          }
        })
        .catch(err => {
          console.error(err)
          console.log("이미 존재하는 전화번호 입니다.")
        })
      
      }else {
        alert("비밀번호가 일치하지 않습니다.")
      }
      }

    
    console.log('check')
    console.log(this.state.emailCheck)
    console.log(this.state.nameCheck)
    console.log(this.state.nicknameCheck)
    console.log(this.state.passwordCheck)
    

  }

  render() {

    
    return (
      <div className="item" 
      style={{
        width:'500px',
        height:'500px',
        margin: '100px 50px'
      }}>

    <h3>우리동네 파트너쉽,</h3>
      <p style={{
        fontSize:'50px'
      }}>HANDS</p>
      <div style={{
        marginTop:'30px'
      }}>
        <form
          onSubmit={this.onSubmitHandler}
        >

        <input if="name" placeholder="이름" type="text" value={this.state.name} onChange={this.onNameHandler}
         style={{
          height:'40px',
          width:'300px',
        }}></input>
        <button for="name" onClick={this.checkName}>중복체크</button>

        <input if="nickname" placeholder="닉네임" type="text" value={this.state.nickname} onChange={this.onNicknameHandler}
         style={{
          height:'40px',
          width:'300px',
          marginTop:'15px'
        }}></input>
        <button for="nickname" onClick={this.checkNickname}>중복체크</button>


        <input id="email" placeholder="이메일" type="email" value={this.state.Email} onChange={this.onEmailHandler}
        style={{
          height:'40px',
          width:'300px',
          marginTop:'15px'
        }}></input>
        <button for="email" onClick={this.checkEmail}>중복체크</button>



        <input placeholder="비밀번호" type="password" value={this.state.password} onChange={this.onPasswordHandler}
        style={{
          height:'40px',
          width:'300px',
          marginTop:'15px'

        }}></input>

        <input placeholder="비밀번호확인" type="password" value={this.confirmPassword} onChange={this.onConfirmPasswordHandler}
        style={{
          height:'40px',
          width:'300px',
          marginTop:'15px'
        }}></input>
        <br/>

        <input placeholder="전화번호" type="text" value={this.state.phone} onChange={this.onPhoneHandler}
        style={{
          height:'40px',
          width:'300px',
          marginTop:'15px'
        }}></input>
        <br/>

        <input placeholder="주소" type="text" value={this.state.address} onChange={this.onAddressHandler}
        style={{
          height:'40px',
          width:'300px',
          marginTop:'15px'
        }}></input>
        <br/>

        <input placeholder="성별" type="text" value={this.state.gender} onChange={this.onGenderHandler}
        style={{
          height:'40px',
          width:'300px',
          marginTop:'15px'
        }}></input>
        <br/>

        <input placeholder="소개" type="textarea" value={this.state.description} onChange={this.onDescriptionHandler}
        style={{
          height:'40px',
          width:'300px',
          marginTop:'15px'
        }}></input>
        <br/>

        

        <Button variant="warning"
          type="submit"
          style={{
            width:'300px',
            margin:'auto',
            marginTop:'15px'

        }}>회원가입</Button>
        <br/>


      </form>
      </div>

    </div>
    );
  }
}


export default JoinAccount;
