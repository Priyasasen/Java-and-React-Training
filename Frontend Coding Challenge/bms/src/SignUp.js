import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { Button } from 'antd';

function SignUp() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const signupUser = (e) => {
    e.preventDefault();
    const signupData = { username, password };

    axios.post('http://localhost:8086/auth/signup', signupData) 
      .then(response => {
        alert('Signup successful! You can now log in.');
        navigate('/login');
      })
      .catch(error => {
        console.error('Signup error:', error);
        alert('Signup failed! Please try again.');
      });
  };

  return (
    <div className="form-container">
      <h2>Sign Up</h2>
      <form onSubmit={signupUser}>
        <div className="form-group">
          <label>Username</label><br />
          <input  type="text"   placeholder="Choose Username" value={username}  onChange={(e) => setUsername(e.target.value)} required  /><br /><br />
        </div>
        <div className="form-group">
          <label>Password</label><br />
          <input
            type="password"
            placeholder="Choose Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          /><br /><br />
        </div>
       <Button type="primary" htmlType="submit"> SignUp</Button>

      </form>
      <Button type="link" onClick={() => navigate('/login')} style={{ padding: 0 }}>   Login
  </Button>
    </div>
  );
}

export default SignUp;
