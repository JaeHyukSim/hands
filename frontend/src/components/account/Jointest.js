import axios from 'axios';
import React from 'react';


class Jointest extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      email: '',
      password:'',
    }
  }
  onEmailHandler = e => {
    this.setState({
      email:e.target.value
    })
  }
  onPasswordHandler = (e) => {
    this.setState({
      password: e.target.value
    })
  }
  onSubmitHandler = (e) => {
    e.preventDefault()


    const signupInfo = {
      userId:this.state.email,
      password: this.state.password,
    }

    axios.post('http://i4d101.p.ssafy.io:8080/auth/join',JSON.stringify(signupInfo),
    {headers:{
      'Content-Type': 'application/json'
    }})
    .then(res => {
      console.log(res)
    })
    .catch(err => {
      console.log('axios오류')
      console.error(err)
    })
  
  }
  render() {
    
    return (
      <div>
        <h2>Jointest</h2>
        <label for="email" >이메일</label>
        <input id="email" type="email" value={this.state.email} onChange={this.onEmailHandler}></input>
        <label for="password" >비밀번호</label>
        <input id="password" type="password" value={this.state.password} onChange={this.onPasswordHandler}></input>
        <button onClick={this.onSubmitHandler}>회원가입</button>
      </div>
    );
  }

}




export default Jointest;
