import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import withStyles from '@material-ui/core/styles/withStyles';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import BaseDialog from './BaseDialog';
import { Paper, Snackbar, IconButton } from '@material-ui/core';
import CloseIcon from '@material-ui/icons/Close';

const styles = theme => ({
  container: {
    maxWidth: 600,
    flexGrow: 1,
    textAlign: 'center',
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'center'
  },
  bottomMargin: {
    marginBottom: theme.spacing.unit * 2
  },
  paper: {
    padding: theme.spacing.unit * 3,
    textAlign: 'left',
    color: theme.palette.text.secondary
  },
  itemContainer: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'flex-start',
    [theme.breakpoints.down('sm')]: {
      display: 'flex',
      flexDirection: 'column',
      justifyContent: 'center'
    }
  },
  baseline: {
    alignSelf: 'baseline',
    marginLeft: theme.spacing.unit * 4,
    [theme.breakpoints.down('sm')]: {
      display: 'flex',
      flexDirection: 'column',
      textAlign: 'center',
      alignItems: 'center',
      width: '100%',
      marginTop: theme.spacing.unit * 2,
      marginBottom: theme.spacing.unit * 2,
      marginLeft: 0
    }
  },
  inline: {
    display: 'inline-block',
    marginLeft: theme.spacing.unit * 4,
    [theme.breakpoints.down('sm')]: {
      marginLeft: 0
    }
  },
  inlineRight: {
    width: '30%',
    textAlign: 'right',
    marginLeft: 50,
    alignSelf: 'flex-end',
    [theme.breakpoints.down('sm')]: {
      width: '100%',
      margin: 0,
      textAlign: 'center'
    }
  }

});

class PreviewDialog extends Component {

    state = {
        "snackbar": false,
        "open": true
    }
 handleSnackClose = event =>{
     this.setState({"snackbar": false});
 }
 
  addCandidate = event => {
      var candidate = this.props.candidate;
      var xhr = new XMLHttpRequest();
      xhr.open("POST", "http://localhost:9090/api/v1/candidates");
      xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
      xhr.send(JSON.stringify(candidate));
      var that = this;
      xhr.onreadystatechange = function(e){
        if ( 4 == this.readyState ) {
            that.setState({snackbar: true});
        }
      }
      this.props.onClose()
  }
  render() {
    const { classes } = this.props;
    this.state.candidate = this.props.candidate;
    return (
      <BaseDialog {...this.props}>
        <div className={classes.bottomMargin}>
            <Paper className={classes.paper}>
            <div className={classes.itemContainer}>
                
                <div className={classes.baseline}>
                <div>
                <Typography style={{ textTransform: 'uppercase' }} color='secondary' gutterBottom>
                    Name
                </Typography>
                <Typography variant="h4" gutterBottom>
                    {this.props.candidate.name}
                </Typography>
                </div>

                
                <div className={classes.inline}>
                    <Typography style={{ textTransform: 'uppercase' }} color='secondary' gutterBottom>
                    Email
                    </Typography>
                    <Typography variant="h6" gutterBottom>
                    {this.props.candidate.email}
                    </Typography>
                </div>
                <div className={classes.inline}>
                    <Typography style={{ textTransform: 'uppercase' }} color='secondary' gutterBottom>
                    Phone
                    </Typography>
                    <Typography variant="h6" gutterBottom>
                    {this.props.candidate.phoneNo}
                    </Typography>
                </div>
                <div className={classes.inline}>
                    <Typography style={{ textTransform: 'uppercase' }} color='secondary' gutterBottom>
                    Experience
                    </Typography>
                    <Typography variant="h6" gutterBottom>
                    {this.props.candidate.experience} years
                    </Typography>
                </div>
                <div className={classes.inline}>
                    <Typography style={{ textTransform: 'uppercase' }} color='secondary' gutterBottom>
                    Skills
                    </Typography>
                    <Typography variant="h6" gutterBottom>
                    {this.props.candidate.skills}
                    </Typography>
                </div>
                <div className={classes.inline}>
                    <Typography style={{ textTransform: 'uppercase' }} color='secondary' gutterBottom>
                    Year of passout
                    </Typography>
                    <Typography variant="h6" gutterBottom>
                    {this.props.candidate.passoutYear}
                    </Typography>
                </div>
                </div>
                
                
            </div>
            </Paper>
        </div>
        <Button onClick={this.addCandidate} className={classes.bottomMargin} variant='contained' color="primary" autoFocus>
          Confirm
        </Button>
        <Button variant='outlined' onClick={this.props.onClose} color="primary" autoFocus>
          Cancel
        </Button>
        <Snackbar
          anchorOrigin={{
            vertical: 'bottom',
            horizontal: 'left',
          }}
          open={this.state.snackbar}
          autoHideDuration={6000}
          onClose={this.handleSnackClose}
          ContentProps={{
            'aria-describedby': 'message-id',
          }}
          message={<span id="message-id">Note archived</span>}
          action={[
            <IconButton
              key="close"
              aria-label="Close"
              color="inherit"
              className={classes.close}
              onClick={this.handleSnackClose}
            >
              <CloseIcon />
            </IconButton>,
          ]}/>
      </BaseDialog>
      
      
    )
  }
}

export default withRouter(withStyles(styles)(PreviewDialog));
