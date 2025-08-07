import './App.css';

function App() {
  const element = "Office Space";
  const jsxatt = <img src={"officespace.png"} width="25%" height="25%" alt="Office Space" />;
  const officeSpace = [
    { Name: "DBS", Rent: 50000, Address: "Chennai" },
    { Name: "WeWork", Rent: 75000, Address: "Bangalore" },
    { Name: "Regus", Rent: 55000, Address: "Mumbai" }
  ];

  return (
    <div className="App">
      <h1>{element}, at Affordable Range</h1>
      {jsxatt}
      {officeSpace.map((item, index) => {
        let colors = [];
        if (item.Rent <= 60000) {
          colors.push('textRed');
        } else {
          colors.push('textGreen');
        }
        return (
          <div key={index}>
            <h2>Name: {item.Name}</h2>
            <h3 className={colors.join(' ')}>Rent: Rs. {item.Rent}</h3>
            <h3>Address: {item.Address}</h3>
            <hr></hr>
          </div>
        );
      })}
    </div>
  );
}

export default App;
