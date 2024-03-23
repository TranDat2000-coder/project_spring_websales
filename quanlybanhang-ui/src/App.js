
import './App.css';
import { useEffect, useState } from 'react';
import { Route, Routes } from 'react-router-dom';
import HomeAdmin from './components/admin/HomeAdmin';
import Login from './components/admin/Login'
import AuthService from './components/service/auth-service';
import EventBus from './commons/event-bus';
import Products from './components/admin/products/Products';
import AdminIndex from './components/AdminIndex';
import WebIndex from './components/WebIndex';

function App() {

  const [currentUser, setCurrentUser] = useState(undefined)

  useEffect(() => {
    const user = AuthService.getCurrentUser();
    if (user) {
      setCurrentUser(user);
    }

    // EventBus.on("logout", () => {
    //   logOut();
    // });

    // return () => {
    //   EventBus.remove();
    // }


  }, []);

  console.log("Current user: ", currentUser);

  const logOut = () => {
    AuthService.logout();
    setCurrentUser(undefined);
  }

  return (
    <div>
      {/* <Router>
        <Routes>
          <Route path="/" element={currentUser ? <HomeAdmin /> : <Login />} />
          <Route path="/home" element={currentUser ? <HomeAdmin /> : <Login />} />
          <Route path="/login" element={<Login />} />
        </Routes>
      </Router> */}

      <Routes>
        <Route path='/admin/*' element={<AdminIndex />} >
          {/* <Route path='home/' element={<HomeAdmin />} />
            <Route path='login' element={<Login />} /> */}
        </Route>
        <Route path='/web/*' element={<WebIndex />} />
      </Routes>

    </div>
  );
}

export default App;
