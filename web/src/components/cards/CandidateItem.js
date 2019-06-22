import React, { Component } from 'react';
import withStyles from '@material-ui/core/styles/withStyles';
import Typography from '@material-ui/core/Typography';
import Paper from '@material-ui/core/Paper';

const styles = theme => ({
    bottomMargin: {
        marginBottom: theme.spacing.unit * 2
    },
    paper: {
        padding: theme.spacing.unit * 3,
        textAlign: 'left',
        color: theme.palette.text.secondary
    },
    inline: {
        display: 'inline-block',
        marginLeft: theme.spacing.unit * 4,
        [theme.breakpoints.down('sm')]: {
          marginLeft: 0
        }
    }
})

class CandidateItem extends Component {

  render() {
    const { classes } = this.props;

    return (
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
    )
  }
}

export default withStyles(styles)(CandidateItem);
