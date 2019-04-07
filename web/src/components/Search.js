import Grid from '@material-ui/core/Grid';
import React, { Component } from 'react';
import { CssBaseline, TextField, Typography, Button, Paper, Table, TableHead, TableRow, TableCell, TableBody } from '@material-ui/core';
import Topbar from './Topbar';
import { withRouter, Link } from 'react-router-dom';
import withStyles from '@material-ui/core/styles/withStyles';

const backgroundShape = require('../images/shape.svg');
const styles = theme => ({
    root: {
        flexGrow: 1,
        backgroundColor: theme.palette.grey['100'],
        overflow: 'hidden',
        background: `url(${backgroundShape}) no-repeat`,
        backgroundSize: 'cover',
        backgroundPosition: '0 400px',
        paddingBottom: 200
    },
    paper: {
        padding: theme.spacing.unit * 3,
        textAlign: 'left',
        color: theme.palette.text.secondary
    },
    topBar: {
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center'
    },
    block: {
        padding: theme.spacing.unit * 2,
    },
    grid: {
        width: 1200,
        margin: `0 ${theme.spacing.unit * 2}px`,
        [theme.breakpoints.down('sm')]: {
            width: 'calc(100% - 20px)'
        }
    },

    tableGrid: {
        width: 1400,
        margin: `0 ${theme.spacing.unit * 2}px`,
        [theme.breakpoints.down('sm')]: {
            width: 'calc(100% - 20px)'
        }
    },
    textField: {
        marginLeft: theme.spacing.unit,
        marginRight: theme.spacing.unit,
    },
    actionButton: {
        textTransform: 'uppercase',
        margin: theme.spacing.unit,
        width: 152,
        height: 36
    },
    table: {
        minWidth: 700,
    },
});

let id = 0;
function createData(name, company, experience, salary) {
  id += 1;
  return { id, name, company, experience, salary };
}

// const rows = [
//   createData('Employee1', 'SAP', 5, 60000),
//   createData('Employee2', 'SAP', 5, 60000),
//   createData('Employee3', 'SAP', 5, 60000)
// ];

class Search extends Component {
    state = {
        experience: 0,
        skills: "",
        passoutYear: 0,
        name: "",
        phoneNo: "",
        email: "",
        rows: []
    };

    handleChange = name => event => {
        this.setState({
            [name]: event.target.value,
        });
    }

    handleSearch = event => {
        
        fetch("http://localhost:9090/api/v1/candidates")
        .then(res => res.json())
        .then(
          (result) => {
            this.setState({
              isLoaded: true,
              rows: result
            });
          },
          // Note: it's important to handle errors here
          // instead of a catch() block so that we don't swallow
          // exceptions from actual bugs in components.
          (error) => {
            this.setState({
              isLoaded: true,
              error
            });
          }
        )
        this.updateSearchResults();
    }
    updateSearchResults(){
        const { experience, skills, passoutYear, name,
            phoneNo, email } = this.state;
        console.log(this.state);
    }

    render() {
        const { classes } = this.props;
        const { experience, skills, passoutYear, name,
            phoneNo, email } = this.state;
        const currentPath = this.props.location.pathname

        return (
            <React.Fragment>
                <CssBaseline />
                <Topbar currentPath={currentPath} />
                <div className={classes.root}>
                    <Grid container justify="center">
                    <form>
                        <Grid spacing={24} alignItems="center" container className={classes.grid}>
                            <Grid item xs={12} md={6}>
                                    <div className={classes.block}>
                                        <Typography variant="h6" gutterBottom>Search Candidates</Typography>
                                        <Typography variant="body1">
                                            Apply the filters below to search from the list of Candidates.
                                        </Typography>
                                    </div>
                            </Grid>
                            <Grid item xs={12}>
                                
                                    <TextField
                                        id="tf-search-name"
                                        label="Name"
                                        className={classes.textField}
                                        value={this.state.name}
                                        onChange={this.handleChange('name')}
                                        margin="normal"
                                        variant="outlined"
                                    />

                                    <TextField
                                        id="tf-search-email"
                                        label="Email"
                                        className={classes.textField}
                                        value={this.state.email}
                                        onChange={this.handleChange('email')}
                                        margin="normal"
                                        variant="outlined"
                                    />

                                    <TextField
                                        id="tf-search-phoneno"
                                        label="Phone"
                                        className={classes.textField}
                                        value={this.state.phoneNo}
                                        onChange={this.handleChange('phoneNo')}
                                        margin="normal"
                                        variant="outlined"
                                    />
                            </Grid>
                            <Grid item xs={12} xl={4}>
                                    <TextField
                                        id="tf-search-exp"
                                        label="Experience (Years)"
                                        className={classes.textField}
                                        value={this.state.experience}
                                        onChange={this.handleChange('experience')}
                                        margin="normal"
                                        variant="outlined"
                                    />
                                    <TextField
                                        id="tf-search-skills"
                                        label="Skills"
                                        className={classes.textField}
                                        value={this.state.skills}
                                        onChange={this.handleChange('skills')}
                                        margin="normal"
                                        variant="outlined"
                                    />
                                    <TextField
                                        id="tf-search-passoutyear"
                                        label="Year of passout"
                                        className={classes.textField}
                                        value={this.state.passoutYear}
                                        onChange={this.handleChange('passoutYear')}
                                        margin="normal"
                                        variant="outlined"
                                    />
                            </Grid>
                            <Grid item xs={12} md={6}>
                                <div className={classes.topBar}>
                                <div className={classes.block}>
                                    <Typography variant="body1">
                                    Once filters are selected, Click on search
                                    </Typography>
                                </div>
                                <div>
                                    <Button onClick={this.handleSearch} variant="contained"  color='primary' className={classes.actionButton}>
                                    Search
                                    </Button>
                                </div>
                                </div>
                            </Grid>
                        </Grid>
                        </form>


                        <Grid spacing={24} alignItems="center" container className={classes.tableGrid}>
                        <Grid item xs={12}>
                        <Paper className={classes.paper}>
                            <Table className={classes.table}>
                                <TableHead>
                                    <TableRow>
                                        <TableCell>Name</TableCell>
                                        <TableCell align="right">Company</TableCell>
                                        <TableCell align="right">Experience (years)</TableCell>
                                        <TableCell align="right">Current CTC</TableCell>
                                    </TableRow>
                                </TableHead>
                                <TableBody>
                                    {this.state.rows.map(row => (
                                        <TableRow key={row.id}>
                                        <TableCell component="th" scope="row">
                                            {row.name}
                                        </TableCell>
                                        <TableCell align="right">{row.company}</TableCell>
                                        <TableCell align="right">{row.experience}</TableCell>
                                        <TableCell align="right">{row.salary}</TableCell>
                                        </TableRow>
                                    ))}
                                </TableBody>
                            </Table>
                        </Paper>
                        </Grid>
                        </Grid>
                    </Grid>
                    
                    
                </div>

            </React.Fragment>

        )
    }
}

export default withRouter(withStyles(styles)(Search));