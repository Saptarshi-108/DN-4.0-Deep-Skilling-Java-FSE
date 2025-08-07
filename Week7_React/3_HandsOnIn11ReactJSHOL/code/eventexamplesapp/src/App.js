

import React, { useState } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  const [count, setCount] = useState(5);

  const increment = () => {
    setCount(prev => prev + 1);
    sayHello();
    showStaticMessage();
  };

  const sayHello = () => {
    window.alert('Hello! Member1');
  };

  const showStaticMessage = () => {
    window.alert('This is a static message');
  };

  const decrement = () => {
    setCount(prev => prev - 1);
  };

  const sayWelcome = (msg) => {
    window.alert(msg);
  };

  const handleClick = (e) => {
    window.alert('I was clicked');
  };

  return (
    <div className="App" style={{ marginLeft: 20, marginTop: 20 }}>
      <div>{count}</div>
      <button onClick={increment}>Increment</button><br />
      <button onClick={decrement}>Decrement</button><br />
      <button onClick={() => sayWelcome('welcome')}>Say welcome</button><br />
      <button onClick={handleClick}>Click on me</button><br /><br />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
