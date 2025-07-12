import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import { Button } from 'antd';
import 'antd/dist/reset.css'; 
   


function BookList() {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    const token = localStorage.getItem('token');

    axios.get('http://localhost:8086/books/getAllBooks', {
      headers: { Authorization: `Bearer ${token}` }
    })
    .then(response => setBooks(response.data))
    .catch(error => {console.error('Error fetching books', error);
    alert('Unauthorized or session expired!');
    });
  }, []);

  return (
    <div style={{ padding: '20px' }}>
      <h2>Book Library</h2>

    <div style={{ display: 'flex', gap: '10px', marginBottom: '20px' }}>
  <Link to="/add-book">
    <Button type="primary">Add Book</Button>
  </Link>
  <Link to="/delete-book">
    <Button type="default">Delete Book</Button>
  </Link>
 </div>
      <ul style={{ listStyle: 'none', padding: 0 }}>
        {books.map(book => (
          <li
            key={book.isbn}
            style={{
              marginBottom: '15px',
              padding: '10px',
              border: '1px solid #ccc',
              borderRadius: '8px',
              display: 'flex',
              justifyContent: 'space-between',
              alignItems: 'center'
            }}
          >
            <div>
              <strong>{book.title}</strong> - {book.author} ({book.publicationYear}) <small>[{book.isbn}]</small>
            </div>
            <Link to={`/update-book/${book.isbn}`}>
             <Button type="primary" htmlType="submit"> Edit </Button> 
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BookList;
