import './App.css';
import AppBar from '@mui/material/AppBar';
import Typography from '@mui/material/Typography';

function App() {
  return (
    <div className="App">
      <AppBar position="static">
          <Typography variant="h6" component="div" sx={{flexGrow: 1}}>
              Contacts
          </Typography>
      </AppBar>
    </div>
  );
}

export default App;
