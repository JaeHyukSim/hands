import React from 'react';
import Button from 'react-bootstrap/Button'
import { Link } from "react-router-dom"


class FindAccount extends React.Component {
  constructor(props) {
    super(props)

    this.state = {
      name:'',
      phone:'',
    }

  }

  onNameHandler = e =>{
    this.setState({
      name: e.target.value
    })
  }

  onPhoneHandler = e =>{
    this.setState({
      phone: e.target.value
    })
  }

  onSubmitHandler = e => {
    e.preventDefault()

    console.log("submit")
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
          <input placeholder="이름" value={this.state.name} onChange={this.onNameHandler} style={{
            height:'40px',
            width:'300px'
          }}></input>
          <br/>
          <input placeholder="전화번호 ( '-' 빼고 입력해주세요.)" value={this.state.phone} onChange={this.onPhoneHandler} style={{
            height:'40px',
            width:'300px',
            marginTop:'25px'
          }}></input>

          
          <Button variant="secondary"
          type="submit"
          style={{
            marginTop:'20px',
            marginLeft:'155px'
          }}
          >
            이메일확인하기
          </Button>
          <br/>
        </form>
      </div>


    </div>
    );
  }
}


export default FindAccount;

