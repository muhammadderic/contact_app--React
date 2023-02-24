import { useEffect, useState } from "react"
// import AddContact from "./pages/AddContact"
import ContactList from "./pages/ContactList"

function App() {
  const [contacts, setContacts] = useState([])

  useEffect(() => {
    fetch("http://localhost:4000/contacts")
      .then(res => res.json())
      .then(data => setContacts(data))
  }, [])

  return (
    // <AddContact />
    <ContactList contacts={contacts} />
  )
}

export default App
