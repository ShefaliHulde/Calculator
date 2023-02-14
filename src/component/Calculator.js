import React ,{useState} from 'react';
import './Calculator.css';
const Calculator =() => {

    

    const [result,setResult]= useState("");
    const[history,setHistory]=useState([]);
    
     
    const handleClick=(e)=>{
       setResult(result.concat(e.target.name));
    }

    const clear=()=>{
        setResult("");
    }

    const backspace = ()=> {
        setResult(result.slice(0, result.length-1));
    }


    const calculate = () => {
        const history = {
            "expression":result
         }
        // setResult(eval(result).toString());
        fetch("http://localhost:8080/calculate", {
            method: "POST",
            headers: { "content-type": "application/json" },
            body: JSON.stringify(history)
        })
        .then(res => res.text())
        .then((result) => {
            alert(result);
            setResult(result);
            
        
        });
    }
        
       

        
        const clickSave=()=>{
            const memory = {
               "memory":result
            }
            fetch("http://localhost:8080/save", {
            method: "POST",
            headers: { "content-type": "application/json" },
            body: JSON.stringify(memory)
        }).then(()=>{
            console.log("sent");
        })
        
    }

    const clickClearMemory=()=>{

        fetch("http://localhost:8080/delete", { method: 'DELETE' })
        .then(() => console.log("deleted"));
    
}
    const showHistory=()=>{
        fetch("http://localhost:8080/history", {
            method: 'GET',
            headers: { 'Content-type': 'application/json' },
        }).then((res) => res.json())
        .then((json) => {
            
         setHistory(json)
 
          console.log(json);
                       
         });
    }
   
    
    return(
        
        <div className="calc-body">
        
       
        <form className='calc-screen'>
           
            <input type="text" value={result} />
        </form>
        
        
        <div className="calc-button-row">
        <button className="ac" onClick={clickClearMemory} >MC</button>
            <button className="opt" onClick={clickSave} >MS</button>
            <button className="opt" onClick={handleClick} >M+</button>
            <button className="opt" onClick={handleClick} >M-</button>
            <button className="ac" onClick={clear} id="Clear">AC</button>
            <button className="opt" onClick={handleClick} name="^">^</button>
            <button className="opt" onClick={handleClick} name="%">&#37;</button>
            <button className="opt" onClick={handleClick} name="/">&divide;</button>
            <button onClick={handleClick} name="7">7</button>
            <button onClick={handleClick} name="8">8</button>
            <button onClick={handleClick} name="9">9</button>
            <button className="opt" onClick={handleClick} name="*">&#215;</button>
            <button onClick={handleClick} name="4">4</button>
            <button onClick={handleClick} name="5">5</button>
            <button onClick={handleClick} name="6">6</button>
            <button className="opt" onClick={handleClick} name="-">&#8722;</button>
            <button onClick={handleClick} name="1">1</button>
            <button onClick={handleClick} name="2">2</button>
            <button onClick={handleClick} name="3">3</button>
            <button className="opt" onClick={handleClick} name="+">&#43;</button>
            <button onClick={handleClick} name="0">0</button>
            <button onClick={handleClick} name=".">.</button>
            <button onClick={backspace} id="backspace">←</button>
            <button className="opt" onClick={calculate} id="result">&#61;</button>
            <button className='history' onClick={showHistory}>History</button>
        </div>
        </div>
    );
}
export default Calculator;