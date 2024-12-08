import React, { useState } from 'react';
import mortgageLoanService from "../services/mortgageloan.service";
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import FormControl from '@mui/material/FormControl';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import Select from '@mui/material/Select';
import TextField from '@mui/material/TextField';
import Typography from '@mui/material/Typography';
import SendIcon from '@mui/icons-material/Send';

const Simulator = () => {
    const [amount, setAmount] = useState('');
    const [interestRate, setInterestRate] = useState('');
    const [termYears, setTermYears] = useState('');
    const [propertyValue, setPropertyValue] = useState('');
    const [monthlyPayment, setMonthlyPayment] = useState(null);
    const [loanType, setLoanType] = useState('');

    // Validación para asegurarse de que el valor es un número positivo
    const handlePositiveValue = (value) => {
        const parsedValue = parseFloat(value);
        return isNaN(parsedValue) || parsedValue < 0 ? '' : parsedValue;
    };

    // Validación para asegurarse de que todos los campos estén completos
    const validateFields = () => {
        if (!amount || !interestRate || !termYears || !propertyValue || !loanType) {
            alert('Please fill in all the fields');
            return false;
        }
        return true;
    };

    // Función para calcular la cuota mensual
    const calculate = async (event) => {
        event.preventDefault();

        // Validar los campos antes de enviar
        if (!validateFields()) return;

        // Convertir los valores a tipos numéricos
        const P = parseFloat(amount);
        const r = parseFloat(interestRate); // Tasa de interés mensual
        const n = parseInt(termYears); // Número total de pagos en meses
        const pValue = parseFloat(propertyValue);
        const loanTypeValue = parseInt(loanType);

        // Imprimir los datos en la consola
        console.log("Datos a enviar:", {
            P,
            r,
            n,
            pValue,
            loanTypeValue
        });

        try {
            // Realizar la solicitud al backend
            const response = await mortgageLoanService.simulate(P, r, n, pValue, loanTypeValue);
            setMonthlyPayment(response.data); // Asignar el resultado a la variable state
        } catch (error) {
            // Manejo de errores si la solicitud falla
            alert('Error calculating the monthly payment: ' + error.message);
        }
    };

    return (
        <Box className="Box-form">
            <Typography variant="h4" align="center" color="textPrimary" gutterBottom>
                Mortgage Credit Simulator
            </Typography>
            <form onSubmit={calculate}>
                {/* Input para el valor de la propiedad */}
                <FormControl fullWidth margin="normal">
                    <TextField
                        label="Property Value"
                        type="number"
                        value={propertyValue}
                        onChange={(e) => setPropertyValue(handlePositiveValue(e.target.value))}
                        required
                    />
                </FormControl>

                {/* Input para el monto del préstamo */}
                <FormControl fullWidth margin="normal">
                    <TextField
                        label="Loan Amount"
                        type="number"
                        value={amount}
                        onChange={(e) => setAmount(handlePositiveValue(e.target.value))}
                        required
                    />
                </FormControl>

                {/* Input para la tasa de interés anual */}
                <FormControl fullWidth margin="normal">
                    <TextField
                        label="Annual Interest Rate (%)"
                        type="number"
                        value={interestRate}
                        onChange={(e) => setInterestRate(handlePositiveValue(e.target.value))}
                        required
                    />
                </FormControl>

                {/* Input para el plazo en años */}
                <FormControl fullWidth margin="normal">
                    <TextField
                        label="Term (Years)"
                        type="number"
                        value={termYears}
                        onChange={(e) => setTermYears(handlePositiveValue(e.target.value))}
                        required
                    />
                </FormControl>

                {/* Selector para el tipo de préstamo */}
                <FormControl fullWidth margin="normal">
                    <InputLabel>Loan Type</InputLabel>
                    <Select value={loanType} onChange={(e) => setLoanType(e.target.value)} required>
                        <MenuItem value="">Select</MenuItem>
                        <MenuItem value="1">First home loan</MenuItem>
                        <MenuItem value="2">Second home loan</MenuItem>
                        <MenuItem value="3">Commercial properties loan</MenuItem>
                        <MenuItem value="4">Remodeling loan</MenuItem>
                    </Select>
                </FormControl>

                {/* Botón para enviar el formulario */}
                <Button
                    type="submit"
                    fullWidth
                    variant="contained"
                    sx={{ backgroundColor: "#2d53ff" }}
                    startIcon={<SendIcon />}
                >
                    Calcular cuota mensual
                </Button>
            </form>

            {/* Mostrar la cuota mensual calculada */}
            {monthlyPayment !== null && (
                <Box marginTop="20px" textAlign="center">
                    <Typography variant="h5" color="textSecondary">
                        Monthly Fee: ${monthlyPayment}
                    </Typography>
                </Box>
            )}
        </Box>
    );
};

export default Simulator;

