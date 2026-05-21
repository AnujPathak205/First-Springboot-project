import { useState, useEffect } from 'react'

function App() {

    const [list, setList] = useState([
        {
            title: "hello",
            content: "this is a way to greet"
        }
    ]);

    const [newData, setNewData] = useState({
        title: "",
        content: ""
    });

    async function FetchData() {

        const response = await fetch(
            "http://localhost:8080/journal"
        );

        const data = await response.json();

        setList(data);
    }

    useEffect(() => {
        FetchData();
    }, []);

    async function handleCreateNewJournal() {

        if (
            newData.title === "" ||
            newData.content === ""
        ) {
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
        );

        await FetchData();

        setNewData({
            title: "",
            content: ""
        });
    }

    return (
        <div
            style={{
                minHeight: "100vh",
                backgroundColor: "#f4f7fb",
                padding: "40px",
                fontFamily: "Arial"
            }}
        >

            <div
                style={{
                    maxWidth: "700px",
                    margin: "auto",
                    backgroundColor: "white",
                    padding: "30px",
                    borderRadius: "15px",
                    boxShadow: "0 4px 15px rgba(0,0,0,0.1)"
                }}
            >

                <h1
                    style={{
                        textAlign: "center",
                        marginBottom: "30px",
                        color: "#333"
                    }}
                >
                    My Journal App
                </h1>

                <h2
                    style={{
                        marginBottom: "20px",
                        color: "#444"
                    }}
                >
                    Create your own Journal
                </h2>

                <div
                    style={{
                        display: "flex",
                        flexDirection: "column",
                        gap: "15px"
                    }}
                >

                    <div>

                        <label
                            htmlFor="title"
                            style={{
                                fontWeight: "bold",
                                display: "block",
                                marginBottom: "5px"
                            }}
                        >
                            Enter Title
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

                            style={{
                                width: "100%",
                                padding: "12px",
                                borderRadius: "8px",
                                border: "1px solid #ccc",
                                fontSize: "16px"
                            }}
                        />

                    </div>

                    <div>

                        <label
                            htmlFor="content"
                            style={{
                                fontWeight: "bold",
                                display: "block",
                                marginBottom: "5px"
                            }}
                        >
                            Enter Content
                        </label>

                        <textarea
                            id="content"
                            value={newData.content}
                            onChange={e =>
                                setNewData({
                                    ...newData,
                                    content: e.target.value
                                })
                            }

                            rows="5"

                            style={{
                                width: "100%",
                                padding: "12px",
                                borderRadius: "8px",
                                border: "1px solid #ccc",
                                fontSize: "16px",
                                resize: "none"
                            }}
                        />

                    </div>

                    <button
                        onClick={handleCreateNewJournal}

                        style={{
                            backgroundColor: "#4f46e5",
                            color: "white",
                            padding: "12px",
                            border: "none",
                            borderRadius: "8px",
                            fontSize: "16px",
                            cursor: "pointer",
                            fontWeight: "bold"
                        }}
                    >
                        Create Journal
                    </button>

                </div>

                <h2
                    style={{
                        marginTop: "40px",
                        marginBottom: "20px",
                        color: "#444"
                    }}
                >
                    Explore Journals
                </h2>

                <div>

                    {
                        list.map((item, index) => (

                            <div
                                key={index}

                                style={{
                                    backgroundColor: "#f9fafb",
                                    padding: "20px",
                                    borderRadius: "10px",
                                    marginBottom: "20px",
                                    border: "1px solid #e5e7eb"
                                }}
                            >

                                <h3
                                    style={{
                                        marginBottom: "10px",
                                        color: "#222"
                                    }}
                                >
                                    {item.title}
                                </h3>

                                <p
                                    style={{
                                        color: "#555",
                                        lineHeight: "1.6"
                                    }}
                                >
                                    {item.content}
                                </p>

                            </div>
                        ))
                    }

                </div>

            </div>

        </div>
    );
}

export default App;