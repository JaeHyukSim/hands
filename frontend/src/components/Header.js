import React from 'react';

import { Navbar, Nav } from 'react-bootstrap';
import { Link } from "react-router-dom"
import Login from './account/Login';


class LoginTag extends React.Component {


  render() {
    return (
      <div>
        <Link to="/home/login" 
        style={{
          color:'darkgray'
        }}
        >
          로그인
        </Link>
      </div>
    )
  }
}

class LogoutTag extends React.Component {

  onLogoutClick= e => {
    console.log('click')
    localStorage.removeItem("userInfo")
    document.location.href = "/home"
  }

  render() {
    return (
      <div>
        <Link href="/home" 
        style={{
          color:'darkgray'
        }}
        onClick={this.onLogoutClick}
        >
          로그아웃
        </Link>
      </div>
    )
  }
}

class MyPage extends React.Component{
  constructor(props) {
    super(props)

    this.state = {

    }
  }

  render() {
    return (
      <Link to="/home/Profile" 
      style={{
        color:'darkgray'
      }}>
        마이페이지
      </Link>
    )
  }


}

class Header extends React.Component {
  constructor(props) {
    super(props);
    
    this.state = {
      userId:'',
      isloggedIn:null
    }
  }

  componentDidMount() {
    //cart state가 local storage에 있으면 불러오기
    if (localStorage.userInfo) {
      console.log(JSON.parse(localStorage.userInfo).userId)
      const userId = JSON.parse(localStorage.userInfo).userId;
      if(userId) {
        this.setState({
          userId:JSON.parse(localStorage.userInfo).userId,
        })
      }
  }
  };

  componentDidUpdate(prevProps) {
    if (localStorage.userInfo){

      if(this.state.userId !== JSON.parse(localStorage.userInfo).userId) {
        this.state.userId = JSON.parse(localStorage.userInfo).userId
      }
    }
  }

  render() {

    return (
      <div>
        <Navbar>
          <Navbar.Brand href="/home">HANDS</Navbar.Brand>
          <Nav className="mr-auto">
            <Nav.Link>
            <Link to="/home/findjob" 
              style={{
              marginTop:'10px',
              color:'darkgray'
              
            }}>
              일거리찾기
            </Link>
              
              </Nav.Link>
            <Nav.Link>
            <Link to="/home/findhandy" 
              style={{
              marginTop:'10px',
              color:'darkgray'
              
            }}>
              핸디찾기
            </Link>
              
              </Nav.Link>
          </Nav>
          <Navbar.Brand>
            { this.state.userId? <MyPage/>:null}
          </Navbar.Brand>
          <Navbar.Brand>
            { this.state.userId ? <LogoutTag/> : <LoginTag/> }


          </Navbar.Brand>
        </Navbar>
      </div>
    );
  }
}


export default Header;

