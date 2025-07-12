import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { Button } from 'antd';

function AddBook() {
  const [book, setBook] = useState({ isbn: '', title: '', author: '', publicationYear: '' });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setBook({ ...book, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const token = localStorage.getItem('token');

    axios.post('http://localhost:8086/books/addBooks', book, {
      headers: {
        Authorization: `Bearer ${token}`
      }
    })
    .then(() => {
      alert('Book added!');
      navigate('/books');
    })
    .catch(err => {
      console.error('Add book error', err);
      alert('Failed to add book');
    });
  };

  return (
    <div className="book-form">
      <h2>Add Book Here</h2>
      <form onSubmit={handleSubmit}>
        <input name="isbn" placeholder="ISBN" onChange={handleChange} required /><br />
        <input name="title" placeholder="Title" onChange={handleChange} required /><br />
        <input name="author" placeholder="Author" onChange={handleChange} required /><br />
        <input name="publicationYear" type="number" placeholder="Year" onChange={handleChange} required /><br />
        <br></br>
       <Button type="primary" htmlType="submit">  Add Book</Button>

      </form>
    </div>
  );
}

export default AddBook;
