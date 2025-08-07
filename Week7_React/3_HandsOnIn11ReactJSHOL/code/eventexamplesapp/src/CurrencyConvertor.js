import React, { useState } from 'react';

function CurrencyConvertor() {
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    let euroAmount = '';
    if (currency.toLowerCase() === 'euro') {
      euroAmount = parseFloat(amount) * 80;
      window.alert(`Converting to Euro Amount is ${euroAmount}`);
    } else {
      window.alert('Please enter Euro as currency');
    }
  };

  return (
    <div>
      <h1 style={{ color: 'green', marginBottom: '24px' }}>Currency Convertor!!!</h1>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '12px' }}>
          <label style={{ marginRight: '10px' }}>
            Amount:
            <input
              type="text"
              value={amount}
              onChange={e => setAmount(e.target.value)}
              style={{ marginLeft: '10px', padding: '4px', width: '120px' }}
            />
          </label>
        </div>
        <div style={{ marginBottom: '12px' }}>
          <label style={{ marginRight: '10px' }}>
            Currency:
            <textarea
              value={currency}
              onChange={e => setCurrency(e.target.value)}
              style={{ marginLeft: '10px', padding: '4px', width: '120px', height: '28px', resize: 'none' }}
            />
          </label>
        </div>
        <button type="submit" style={{ padding: '6px 16px' }}>Submit</button>
      </form>
    </div>
  );
}

export default CurrencyConvertor;
