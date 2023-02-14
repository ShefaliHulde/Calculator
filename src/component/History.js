import React from 'react';
import './History.css';


const History=(props)=>{
    return(

        <div>
            <h2>HTML Table</h2>

<table>
  <tr>
    <th>Expression</th>
    <th>Result</th>
    
  </tr>
  {props.history.map(history => (
  <tr>
      <td>{props.history.expression}</td>
      <td>{props.history.result}</td>
      </tr>
      ))}
//   <tr>
//     <td>Alfreds Futterkiste</td>
//     <td>Maria Anders</td>
   
//   </tr>
 
  </table>
        </div>
    );
}
export default History;