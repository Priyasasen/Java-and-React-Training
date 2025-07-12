
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { Button } from 'antd';


function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const loginUser = (e) => {
    e.preventDefault();
    const loginData = { username, password };

    axios.post('http://localhost:8086/auth/login', loginData)
      .then(response => {
        const token = response.data; 
        localStorage.setItem('token', token);
        alert('Login successful!');
        navigate('/books');
      })
      .catch(error => {
        console.error('Login error:', error);
        alert('Login failed! Please check your credentials.');
      });
  };

  return (
    
    <div className="form-container">

      <h2>Login to Book Library</h2>
      <form onSubmit={loginUser}>
        <div className="form-group">
          <label>Username</label><br />
          <input  type="text"  placeholder="Enter Username"  value={username}  onChange={(e) => setUsername(e.target.value)}    required  /><br /><br />
        </div>
        <div className="form-group">
          <label>Password</label><br />
          <input    type="password"    placeholder="Enter Password"     value={password}    onChange={(e) => setPassword(e.target.value)}    required  /><br /><br />
        </div>
       <Button type="primary" htmlType="submit">Login</Button>

      </form>
      <p>Don't have an account? <a href="/signup" style={{ color: 'darkgreen', textDecoration: 'none' }}>
    Register
  </a></p>
    </div>
  );
}

export default Login;
