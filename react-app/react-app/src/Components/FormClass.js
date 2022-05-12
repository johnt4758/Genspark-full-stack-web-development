import React from "react";

export default class CustomForm extends React.Component{
    constructor(){
        super();
        this.state = {
            firstName: '',
            lastName: '',
            occupation: '',
            country: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.publish = this.publish.bind(this);
    }

    handleChange({target}){
        this.setState({
            [target.name]: target.value
        });
    }

    publish(){
        alert('You entered: \n' + 
                this.state.firstName + '\n' +
                this.state.lastName + '\n' + 
                this.state.occupation + '\n' + 
                this.state.country);
    }

    render(){
        return(
            <div>
                <div>
                    <form>
                        <label><strong>First Name:</strong></label>
                        <input type="text" id="firstName" name="firstName" placeholder="Enter your first name" 
                            value={this.state.firstName} onChange={this.handleChange}>
                        </input>

                        <label><strong>Last Name:</strong></label>
                        <input type="text" id="lastName" name="lastName" placeholder="Enter your last name" 
                            value={this.state.lastName} onChange={this.handleChange}>
                        </input>

                        <label><strong>Occupation:</strong></label>
                        <input type="text" id="occupation" name="occupation" placeholder="Enter your occupation" 
                            value={this.state.occupation} onChange={this.handleChange}>
                        </input>

                        <label><strong>Country:</strong></label>
                        <select id="country" name="country" value={this.state.country} onChange={this.handleChange}>
                            <option>Australia</option>
                            <option>Ireland</option>
                            <option>United Kingdom</option>
                            <option>United States</option>
                            <option>Wales</option>
                        </select>

                        <button className="submit" onClick={this.publish}>Submit</button>
                    </form>
                </div>
                <div>

                </div>

            </div>
        );
    }
}