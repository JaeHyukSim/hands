import React, { Component } from 'react';
import { Route } from 'react-router-dom';
import { Home } from '../pages';
import {Redirect} from 'react-router'

class App extends Component {
  render() {
    return ( 
      <div style={{
        width:'1400px',
        margin:'auto'
      }}>
        <Redirect exact path="/" to='/home'/>
        <Route path="/home" component={Home}/>
      </div>
    );
  }
}

export default App;