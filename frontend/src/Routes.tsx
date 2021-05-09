import Dashboard from 'pages/dashboard';
import Home from 'pages/home';
import { Route, Switch } from 'react-router';
import { BrowserRouter} from 'react-router-dom';
function Routes() {
    return (
       <BrowserRouter>
       <Switch>

           <Route path="/" exact>
            <Home />
           </Route>

           <Route path="/">
               <Dashboard />
            <Home />
           </Route>
           
       </Switch>
       </BrowserRouter>
    );
  }
  
  export default Routes;
  