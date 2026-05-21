import { useState , useEffect} from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'

function App() {
    const [list,setList] = useState([{title:"hello",content:"this is a way to greet"}]);
    const [newData,setNewData] = useState({title:"",content:""});

    async function FetchData(){
        const response = await fetch("http://localhost:8080/journal")
        const data = await response.json();
        setList(data);
    }

     useEffect(() => {
        FetchData();
      }, []);

      async function handleCreateNewJournal(){
          if(newData.title === "" || newData.content === ""){
                return;
          }

          await fetch(
              "http://localhost:8080/journal",
              {
                method: "POST",

                headers: {
                  "Content-Type": "application/json"
                },

                body: JSON.stringify(newData)
              }
          )

          await FetchData();
          setNewData({title:"",content:""})
      }

  return(
      <>
        <h2>Create your own Journal</h2>
        <label htmlFor="title" >
            Enter title:
        </label>
        <input
          type="text"
          id="title"
          value={newData.title}
          onChange={e =>
            setNewData({
              ...newData,
              title: e.target.value
            })
          }
        />

        <br/>
        <br/>

        <label htmlFor="content" >
            Enter Content:
        </label>
        <input
          type="text"
          id="content"
          value={newData.content}
          onChange={e =>
            setNewData({
              ...newData,
              content: e.target.value
            })
          }
          />

          <br/><br/>

          <button onClick={handleCreateNewJournal}>Create Journal</button>

        <h1>Explore</h1>
        <div>
            {
                list.map((item,index) =>
                    (<div key={index}>
                            <h3>{item.title}</h3>
                            <p>{item.content}</p>
                            <hr/>
                    </div>)
                )
            }
        </div>
      </>
      );
}

export default App
