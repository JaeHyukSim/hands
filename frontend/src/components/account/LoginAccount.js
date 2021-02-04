import React from 'react';
import { Link } from "react-router-dom"
import Button from 'react-bootstrap/Button'

class LoginAccount extends React.Component {
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
        <input placeholder="이메일" style={{
          height:'40px',
          width:'300px'
        }}></input>
        <br/>
        <input placeholder="비밀번호" style={{
          height:'40px',
          width:'300px',
          marginTop:'25px'
        }}></input>
        <br/>
        <Link to="/home/login/findAccount" 
          style={{
          marginTop:'10px',
          color:'black'
          
        }}>
          비밀번호찾기
        </Link>
        <Button variant="warning"
          style={{
            width:'300px',
            margin:'auto'
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
      </div>


    </div>
    );
  }
}


export default LoginAccount;
