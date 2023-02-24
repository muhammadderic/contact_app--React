import { Avatar, Card, CardHeader, IconButton } from "@mui/material"
import BorderColorIcon from '@mui/icons-material/BorderColor';

function ContactCard({ contact }) {
  return (
    <Card
      sx={{ display: "flex", justifyContent: "space-between" }}>
      <CardHeader
        avatar={
          <Avatar />
        }
        title={contact.name}
        subheader={contact.email} />
      <IconButton>
        <BorderColorIcon />
      </IconButton>
    </Card>
  )
}

export default ContactCard