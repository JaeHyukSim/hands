import React from 'react';
import {Card, CardColumns, CardImg, Col, Container, Image, Row} from 'react-bootstrap'
import logo from '../../img/logo.png';
import freeman from '../../img/freeman.png';
import women from '../../img/women.png'
import style from '../../styles/mainpage.css';
import {Link} from "react-router-dom";


class Main extends React.Component {
    render() {
        return (
            <div>
                <div className="container">
                    <div className="row hero">
                        <div className="diagonal-hero-bg">
                            <div className="stars">
                                <div className="small"/>
                                <div className="medium"/>
                                <div className="big"/>
                            </div>
                        </div>
                    </div>

                    <div className="row hello">
                        <div className="illustration">
                            <Image style={{
                                display: 'inline-block',
                                width: '350px',
                                marginLeft: '13rem',
                            }} src={women}/>
                            <div class="ground"></div>
                            <div class="ground-one"></div>
                            <div class="bush-one"></div>
                            <div class="building-left">
                                <div class="top"></div>
                            </div>
                            <div class="building-right">
                                <div class="top"></div>
                            </div>
                            <div class="building">
                                <div class="top"></div>
                                <div class="window-1"></div>
                                <div class="window-2"></div>
                                <div class="window-3"></div>
                                <div class="window-4"></div>
                                <div class="window-5"></div>
                                <div class="window-6"></div>
                                <div class="window-7"></div>
                                <div class="window-8"></div>
                            </div>
                            <div class="bush-two"></div>
                            <div class="bush-three"></div>
                            <div class="stem-one">
                                <div class="leaves-one"></div>
                                <div class="leaves-two"></div>
                                <div class="branch"></div>
                            </div>
                            <div class="stem-two"></div>
                            <div class="balloon">
                                <div class="base"></div>
                                <div class="head"></div>
                            </div>
                        </div>
                        <div className="d-none d-md-block d-lg-block col-md-6">
                        </div>
                        <div className="col-md-6 col-xs-12">
                            <div className="mainTextDiv">
                                <h1>?????? ????????????</h1>
                                <p className="textSlide"></p>
                                <h1>????????? ????????????.</h1>
                                <div className="text-bottom-button">
                                    <button className="btn btn-lg mainjoinBtn mt-4 mx-2">???????????? ????????????</button>
                                    <button className="btn btn-lg mainjobBtn mt-4 mx-2">????????? ????????????</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <Container fluid className="section1">
                  <Row>
                    <Col md={12}>
                      <div class="section1TextDiv mt-5">
                          <h3>???????????? ?????? ????????? ???????????? ????????? ??????????????? ???????????????.</h3>
                          <p>?????? ????????? ??????, ???????????? ????????? ????????? ???????????????.</p>
                          <Link to="">??? ????????? ???????????? ??????</Link>
                      </div>
                    </Col>
                  </Row>
                </Container>
            </div>
        );
    }
}


export default Main;
