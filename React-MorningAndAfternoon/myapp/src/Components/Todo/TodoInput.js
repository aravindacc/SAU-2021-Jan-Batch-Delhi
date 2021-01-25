import React from 'react';
import Button from 'react-bootstrap/Button';

import InputGroup from 'react-bootstrap/InputGroup';
import Form from 'react-bootstrap/Form';

class TodoInput extends React.Component {
    render() {
        const {placeholder ,value, onChange, addTask} = this.props;
        return (
            <React.Fragment>
                <InputGroup className="mb-3">
                <Form.Control
                    placeholder={placeholder}
                    type="text" value={value}
                    onChange={onChange}
                    />
                    <InputGroup.Append>
                        <Button onClick= {addTask} variant="primary">Add Task</Button>
                    </InputGroup.Append>
                </InputGroup>
            </React.Fragment>
        )
    }
}

export default TodoInput;