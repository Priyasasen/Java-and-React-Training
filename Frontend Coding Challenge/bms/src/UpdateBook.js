import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import { Button } from 'antd';

function UpdateBook() {
  const { isbn } = useParams();
  const navigate = useNavigate();
  const [book, setBook] = useState({ title: '', author: '', publicationYear: '' });

  useEffect(() => {
    const token = localStorage.getItem('token');
    axios.get(`http://localhost:8086/books/${isbn}`, {
      headers: { Authorization: `Bearer ${token}` }
    })
    .then(res => setBook(res.data))
    .catch(err => alert("Can't fetch book details"));
  }, [isbn]);

  const handleChange = (e) => {
    setBook({ ...book, [e.target.name]: e.target.value });
  };

  const handleUpdate = (e) => {
    e.preventDefault();
    const token = localStorage.getItem('token');
    axios.put(`http://localhost:8086/books/${isbn}`, book, {
      headers: { Authorization: `Bearer ${token}` }
    })
    .then(() => {
      alert('Book updated!');
      navigate('/books');
    })
    .catch(err => alert('Failed to update book'));
  };

  return (
    <div className="book-form">
      <h2>Update Book</h2>
      <form onSubmit={handleUpdate}>
        <input name="title" value={book.title} onChange={handleChange} required /><br />
        <input name="author" value={book.author} onChange={handleChange} required /><br />
        <input name="publicationYear" type="number" value={book.publicationYear} onChange={handleChange} required /><br />
        <br></br>
        <Button type="primary" htmlType="submit">  Update Book</Button>
      </form>
    </div>
  );
}

export default UpdateBook;
