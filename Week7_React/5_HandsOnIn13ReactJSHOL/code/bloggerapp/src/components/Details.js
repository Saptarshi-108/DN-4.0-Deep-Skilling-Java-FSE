import '../App.css';

const Details = (props) => {
    const bookdet = (
        (!props.books || props.books.length <= 0) || (
            <ul>
                {props.books.map((book) =>
                    book ? (
                        <div key={book.id}>
                            <h3>{book.bname}</h3>
                            <h4>{book.price}</h4>
                        </div>
                    ) : null
                )}
            </ul>
        )
    );

    const coursedet = (
        props.courses && props.courses.length > 0 ? (
            <ul>
                {props.courses.map((course) =>
                    course && (
                        <div key={course.id}>
                            <h1>{course.cname}</h1>
                            <h4>{course.date}</h4>
                        </div>
                    )
                )}
            </ul>
        ) : (
            <p>No courses available.</p>
        )
    );

    const content = (
        (props.blogs && props.blogs.length > 0) && (
            <ul>
                {props.blogs.map((blog) =>
                    !blog || (
                        <div key={blog.id}>
                            <h1>{blog.topic}</h1>
                            <h4>{blog.author}</h4>
                            <p>{blog.details}</p>
                        </div>
                    )
                )}
            </ul>
        )
    );

    return (
        <div className="details-container">
            <div className="st2">
                <h1>Book Details</h1>
                {bookdet}
            </div>
            <div className="v1">
                <h1>Blog Details</h1>
                {content}
            </div>
            <div className="mystyle1">
                <h1>Course Details</h1>
                {coursedet}
            </div>
        </div>
    );
};

export default Details;