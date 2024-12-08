import httpClient from "../http-common";
import qs from 'qs';  // Usar qs para serializar el objeto

const simulate = (amount, interestRate, termYears, propertyValue, loanType) => {
    const data = { amount, interestRate, termYears, propertyValue, loanType };
    const config = {
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    };
    return httpClient.post("/api/v1/mortgageloan/monthlypayment", qs.stringify(data), config);
}

export default { simulate };
