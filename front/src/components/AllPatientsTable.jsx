import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";

const AllPatientsTable = () => {
  const [patients, setPatients] = useState([]);

  useEffect(() => {
    async function getAllPatients() {
      const urlApi = `http://localhost:8001/api/patients`;
      const res = await fetch(urlApi);
      const data = await res.json();
      setPatients(data);
    }

    getAllPatients();
  }, []);
  return (
    <TableContainer>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Name</TableCell>
            <TableCell align="right">Medical Risk</TableCell>
            <TableCell align="right">Last Update</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {patients.map((row) => (
            <TableRow
              key={row.name}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {<Link to={`/patient/${row.id}`}>{row.name} ↗</Link>}
              </TableCell>
              <TableCell align="right">{row.medicalRisk}</TableCell>
              <TableCell align="right">{row.lastTest}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default AllPatientsTable;
