import React from 'react';
import Header from '../components/Header'
import Footer from '../components/Footer'
import Main from '../components/main/Main'
import Login from '../components/account/Login'
import Join from '../components/account/Join'
import FindJob from '../components/article/FindJob'
import FindHandy from '../components/article/FindHandy'
import Profile from '../components/account/Profile'
import Jointest from '../components/account/Jointest'
import { Route } from 'react-router-dom';
import { Redirect } from 'react-router'


const Home = () => {
  return (
    <div>
      <Header/>
      <Redirect exact path="/" to="/home"/>
      <Route exact path="/home" component={Main}/>
      <Route path="/home/login" component={Login}/>
      <Route path="/home/join" component={Join}/>
      <Route path="/home/findjob" component={FindJob}/>
      <Route path="/home/findhandy" component={FindHandy}/>
      <Route path="/home/Profile" component={Profile}/>
      <Route path="/home/jointest" component={Jointest}/>
      <Footer/>
    </div>
  );
};

export default Home;