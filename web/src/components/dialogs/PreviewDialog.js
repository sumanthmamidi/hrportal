import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import withStyles from '@material-ui/core/styles/withStyles';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import BaseDialog from './BaseDialog';
import { Paper, Snackbar, IconButton } from '@material-ui/core';
import CloseIcon from '@material-ui/icons/Close';
import CandidateItem from '../cards/CandidateItem';

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
      console.log("candidateSaved:"+JSON.stringify(candidate));
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
        <CandidateItem {...this.props}/>
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
