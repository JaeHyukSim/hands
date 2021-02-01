import React from 'react';
import { Link } from "react-router-dom"
import Button from 'react-bootstrap/Button'

class JoinAccount extends React.Component {
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
        <input placeholder="이름" style={{
          height:'40px',
          width:'300px',
        }}></input>
        <input placeholder="전화번호" style={{
          height:'40px',
          width:'300px',
          marginTop:'25px'
        }}></input>
        <input placeholder="이메일" style={{
          height:'40px',
          width:'300px',
          marginTop:'25px'

        }}></input>
        <br/>
        <input placeholder="비밀번호" style={{
          height:'40px',
          width:'300px',
          marginTop:'25px'

        }}></input>
        <input placeholder="비밀번호확인" style={{
          height:'40px',
          width:'300px',
          marginTop:'25px'
        }}></input>
        <br/>

        <Button variant="warning"
          style={{
            width:'300px',
            margin:'auto',
            marginTop:'25px'

        }}>회원가입</Button>
        <br/>

      </div>


    </div>
    );
  }
}


export default JoinAccount;
