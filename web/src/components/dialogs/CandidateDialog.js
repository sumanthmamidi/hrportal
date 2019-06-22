import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';
import withStyles from '@material-ui/core/styles/withStyles';
import Button from '@material-ui/core/Button';
import BaseDialog from './BaseDialog';
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

class CandidateDialog extends Component {

    state = {
        "open": true,
        "candidate": {}
    }
 
 
  handleViewResume = event => {
    console.log("resumeId:"+JSON.stringify(this.state));

    this.getCandidate(this.state.candidate.id, this.getResume )
    
  }

  getResume = (candidate, next) => {
    fetch("http://localhost:9090/api/v1/resume/"+candidate.resumeId)
    .then(res => res.json())
    .then(
      (result) => {
        console.log("Resume:"+JSON.stringify(result));
        window.open('http://localhost:10001/files/'+result.name, '_blank');
      }
    )
  }


  getCandidate = (id, next) => {
    var candidate = {};
    fetch("http://localhost:9090/api/v1/candidates/"+id)
    .then(res => res.json())
    .then(
      (result) => {
        console.log(JSON.stringify(result));
        next(result);
      }
      
    )
  }
  render() {
    const { classes } = this.props;
    this.state.candidate = this.props.candidate;
    return (
      <BaseDialog {...this.props}>
        <CandidateItem {...this.props}/>
        
        <Button onClick={this.handleViewResume} className={classes.bottomMargin} variant='contained' color="primary" autoFocus>
          View Resume
        </Button>
        <Button variant='outlined' onClick={this.props.onClose} color="primary" autoFocus>
          Close
        </Button>
        
      </BaseDialog>
      
      
    )
  }
}

export default withRouter(withStyles(styles)(CandidateDialog));
