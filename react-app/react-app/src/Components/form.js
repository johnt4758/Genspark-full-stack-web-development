import React from 'react'

const form = () => {
  return (
    <div className='design'>
      <div class="container-fluid">
        <div class="row justify-content-center">
          <div class="col-xl-5">
            <form>
              <label for="firstName"><strong>First Name:</strong></label>
              <input type="text" id="firstName" name="firstName" placeholder="Enter your first name" value={this.state.value}></input>

              <label for="lastName"><strong>Last Name:</strong></label>
              <input type="text" id="lastName" name="lastName" placeholder="Enter your last name"></input>

              <label for="occupation"><strong>Occupation:</strong></label>
              <input type="text" id="occupation" name="occupation" placeholder="Enter your occupation"></input>

              <label for="country"><strong>Country:</strong></label>
              <select id="country" name="country">
                  <option>Australia</option>
                  <option>Ireland</option>
                  <option>United Kingdom</option>
                  <option>United States</option>
                  <option>Wales</option>
              </select>
              
              <button class="submit">Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  )
}

export default form