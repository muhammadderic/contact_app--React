import { Container, Grid, Typography } from "@mui/material"
import ContactCard from "../components/ContactCard"

function ContactList({ contacts }) {
  return (
    <Container>
      <Typography
        variant="h5">
        Contact List
      </Typography>
      {contacts.length === 0 ? "No Data" :
        <Grid
          container
          spacing={1}>
          {contacts.map(contact => (
            <ContactCard
              key={contact.id}
              contact={contact} />
          ))}
        </Grid>}
    </Container>
  )
}

export default ContactList