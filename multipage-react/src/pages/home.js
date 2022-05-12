import React from 'react';
import { Col, Container, Row } from 'react-bootstrap';
  
const Home = () => {
  return (
    <Container fluid='md'>
      <Row>
          <Col>1 of 2</Col>
          <Col>2 of 2</Col>
      </Row>
    </Container>
  );
};
  
export default Home;