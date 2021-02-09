import React from 'react';
import axios from 'axios'
import { Link } from "react-router-dom"
import Button from 'react-bootstrap/Button'

class LoginAccount extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      email:'',
      password:'',
      isLogin:null
    };
  }
  onEmailHandler = e => {
    this.setState({
      email: e.target.value
    })
  }
  onPasswordHandler = e => {
    this.setState({
      password: e.target.value
    })
  }
  onSubmitHandler = e => {
    e.preventDefault();

    const login_info = {
      userId:this.state.email,
      password:this.state.password
    }

    axios.post("http://i4d101.p.ssafy.io:8080/auth/login",JSON.stringify(login_info),
    {headers:{
      'Content-Type': 'application/json'
    }})
    .then(res => {
      console.log(res)
      alert("로그인 되었습니다.")

      window.localStorage.setItem('userInfo', JSON.stringify(login_info))
      document.location.href = "/home"
    })
    .catch(err => {
      console.error(err)
      alert ("아이디 혹은 비밀번호를 확인하세요")
    })
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
        marginTop:'50px'
      }}>
        <form onSubmit={this.onSubmitHandler}>
          <label for="email">이메일</label>
          <br/>
          <input id="email" placeholder="이메일 주소" type="email" value={this.state.email} onChange={this.onEmailHandler}
          style={{
            height:'40px',
            width:'300px'
          }}></input>
          <br/>
          <label for="password">비밀번호</label>
          <br/>
          <input id="password" placeholder="비밀번호" type="password" value={this.state.password} onChange={this.onPasswordHandler}
          style={{
            height:'40px',
            width:'300px',
          }}></input>
          <br/>
          <Link to="/home/login/findAccount" 
            style={{
            marginTop:'15px',
            color:'black'
            
          }}>
            비밀번호찾기
          </Link>
          <Button variant="warning"
            type="submit"
            style={{
              width:'300px',
              margin:'auto',
              marginTop:'15px'
          }}>로그인</Button>
          <br/>
          <Button style={{
            marginTop:'30px',
            
          }}>
          <Link to="/home/join" 
          style={{
          marginTop:'10px',
          color:'black'
          
          }}>
            회원가입
          </Link>
          </Button>
          <div>소셜로그인</div>
        </form>
      </div>


    </div>
    );
  }
}


export default LoginAccount;
