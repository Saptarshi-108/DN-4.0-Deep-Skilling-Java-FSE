import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: []
        };
    }

    loadPosts = async () => {
        try {
            const response = await fetch('https://jsonplaceholder.typicode.com/posts');
            if (!response.ok) {
                throw new Error('Failed to fetch posts');
            }
            const data = await response.json();
            const posts = data.map(
                (post) => new Post(post.id, post.title, post.body)
            );
            this.setState({ posts });
        } catch (error) {
            this.setState({ error });
        }
    }

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        alert('Error: ' + error.message);
    }

    render() {
        if (this.state.error) {
            return <h1>Error: {this.state.error.message}</h1>;
        }
        return (
            <div>
                {this.state.posts.map(post => (
                    <div key={post.id}>
                        <h1>{post.title}</h1>
                        <p>{post.body}</p>
                        <hr />
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;
