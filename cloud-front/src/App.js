import React, { useEffect, useState } from 'react';
import './App.css';
import axios from 'axios';
function App() {
    const [projectDetails, setProjectDetails] = useState({});
    const [members, setMembers] = useState([])
    const [projectId, setProjectId] = useState(1);

    useEffect(() => {
        axios.get(`clients/project-details/${projectId}`).then(response => {
            setProjectDetails(response.data);
            setMembers(response.data.members)
        }).catch(error => {
            console.error(error);
        });
    }, [])

    const handleSubmit = (event) => {
        event.preventDefault();
        axios.get(`clients/project-details/${projectId}`).then(response => {
            setProjectDetails(response.data);
            setMembers(response.data.members)
        }).catch(error => {
            console.error(error);
        });
    }
  return (
    <div>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Navbar</a>
        
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <form class="form-inline my-2 my-lg-0" onSubmit={handleSubmit}v>
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="projectId" value={projectId} onChange={(event) => {setProjectId(event.target.value)}}/>
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
        <div className="container">
            <h1>{projectDetails.projectName}</h1>
            <table class="table">
                <thead>
                    <tr>
                    <th scope="col">#</th>
                    <th scope="col">cin</th>
                    <th scope="col">email</th>
                    <th scope="col">firstname</th>
                    <th scope="col">lastname</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        members.map(member => {
                            return (
                                <tr>
                                    <th scope="row">{member.collaboratorId}</th>
                                    <td>{member.cin}</td>
                                    <td>{member.email}</td>
                                    <td>{member.firstName}</td>
                                    <td>{member.lastName}</td>
                                </tr>
                            );
                        })
                    }
                    
                </tbody>
            </table>
        </div>
    </div>
  );
}

export default App;
