import './App.css';
import Details from './components/Details';
import { books, blogs, courses } from './components/Data';


function App() {
  return (
    <Details books={books} blogs={blogs} courses={courses} />
  );
}

export default App;