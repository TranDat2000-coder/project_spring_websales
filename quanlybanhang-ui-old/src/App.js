import React, { useState, useEffect } from "react";

import { Routes, Route } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import AuthService from "./services/auth_service";
import Login from "./components/Login";
import EventBus from "./common/EventBus";
import HomeAdmin from "./components/HomeAdmin";

const App = () => {

  const [currentUser, setCurrentUser] = useState(undefined);

  console.log("currentUser: " + currentUser);

  useEffect(() => {
    const user = AuthService.getCurrentUser();

    if (user) {
      setCurrentUser(user);
    }

    EventBus.on("logout", () => {
      logOut();
    });

    return () => {
      EventBus.remove("logout");
    };
  }, [])

  const logOut = () => {
    AuthService.logOut();
    setCurrentUser(undefined);
  }

  return (
    <div>
      <Routes>
        <Route path="/" element={currentUser ? <HomeAdmin /> : <Login />} />
        <Route path="/home" element={currentUser ? <HomeAdmin /> : <Login />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </div>

  );
};

export default App;
