
import React, { useState } from 'react';
import axios from 'axios';
import { Button } from 'antd';
import {useNavigate } from 'react-router-dom';

function DeleteBook() {
  const [isbn, setIsbn] = useState('');
  const [message, setMessage] = useState('');
  const navigate = useNavigate();
  
  const handleDelete = (e) => {
    e.preventDefault();
    const token = localStorage.getItem('token');

    axios.delete(`http://localhost:8086/books/${isbn}`, {
      headers: {
        Authorization: `Bearer ${token}`
      }
    })
    .then(() => {
      setMessage(`Book with ISBN ${isbn} deleted successfully.`);
      setIsbn('');
      navigate('/books');
    })
    .catch((error) => {
      console.error('Delete failed:', error);
      setMessage('Error: Could not delete the book. Please check ISBN or try again.');
    });
  };

  return (
    <div className="form-container">
      <h2>Delete Book</h2>
      <form onSubmit={handleDelete}>
        <div className="form-group">
          <label>Enter ISBN Number</label>
          <input type="text"  value={isbn}  onChange={(e) => setIsbn(e.target.value)}   placeholder="e.g., 123456"  required  />
        </div>
 <Button type="primary" htmlType="submit"> Delete Book </Button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
}

export default DeleteBook;
