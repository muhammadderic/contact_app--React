import { Button, Container, TextField, Typography } from "@mui/material"
import PlaylistAddIcon from '@mui/icons-material/PlaylistAdd';
import { useState } from "react";

function AddContact() {
  const [name, setName] = useState("")
  const [email, setEmail] = useState("")
  const [nameError, setNameError] = useState(false)
  const [emailError, setEmailError] = useState(false)

  const handleSubmit = (e) => {
    e.preventDefault()
    setNameError(false)
    setEmailError(false)

    if (name === "") {
      setNameError(true)
    }
    if (email === "") {
      setEmailError(true)
    }
    if (name && email) {
      console.log(name, email)
    }
  }

  return (
    <Container sx={{ p: 2 }}>
      <form
        noValidate
        autoComplete="off"
        onSubmit={handleSubmit}>
        <Typography
          variant="h5">
          Add Contact
        </Typography>
        <TextField
          variant="outlined"
          label="Your Name"
          margin="dense"
          required
          fullWidth
          error={nameError}
          onChange={(e) => setName(e.target.value)} />
        <TextField
          variant="outlined"
          label="Your Email"
          type="email"
          margin="dense"
          required
          fullWidth
          error={emailError}
          onChange={(e) => setEmail(e.target.value)} />
        <Button
          variant="contained"
          type="submit"
          color="primary"
          startIcon={<PlaylistAddIcon />}
          sx={{ mt: 1 }}>
          Add
        </Button>
      </form>
    </Container>
  )
}

export default AddContact