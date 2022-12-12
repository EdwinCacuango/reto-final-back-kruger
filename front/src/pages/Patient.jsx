import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

const Patient = () => {
  const [patient, setPatient] = useState([]);
  const [medicalHistory, setMedicalHistory] = useState([]);
  const { id } = useParams();
  const [newTest, setNewTest] = useState(false);

  useEffect(() => {
    async function getOnePatient() {
      const urlApi = `http://localhost:8001/api/patients/${id}`;
      const res = await fetch(urlApi);
      const data = await res.json();
      setPatient(data);
    }

    async function getMedicalHistory() {
      const urlApi = `http://localhost:8002/api/medical-tests/patient/${id}`;
      const res = await fetch(urlApi);
      const data = await res.json();
      setMedicalHistory(data);
    }

    getOnePatient();
    getMedicalHistory();
    console.log(patient);
    console.log(medicalHistory);
  }, []);

  const newTestBtnHandler = () => {
    setNewTest((prev) => !prev);
  };
  return (
    <main>
      {patient ? (
        <div>
          <div>
            <div className="flex items-center justify-between bg-gray-100 p-2 rounded">
              <p>Nombre: {patient.name}</p>
              <p>Riesgo médico: {patient.medicalRisk}</p>
            </div>
            {/* <div>
              <button onClick={newTestBtnHandler}>Nuevo examen</button>
              {
                newTest?
                &&(<div>
                    <input />

                </div>)
              }
            </div> */}
          </div>
          <div className="my-10">
            <h1 className="text-5xl my-10">Todos los exámenes disponibles</h1>
            <div className="overflow-x-auto relative sm:rounded-lg">
              <table className="w-full text dark:text-gray-400">
                <thead className="text-sm text-gray-800 uppercase dark:bg-gray-700 dark:text-gray-400">
                  <tr className="border-b">
                    <th className="py-3 px-6">Fecha</th>
                    <th className="py-3 px-6">Niveles de 02</th>
                    <th className="py-3 px-6">Niveles de azúcar</th>
                    <th className="py-3 px-6">Niveles de grasa</th>
                    <th className="py-3 px-6 text-center">Riesgo</th>
                  </tr>
                </thead>
                <tbody>
                  {medicalHistory.map((test) => {
                    return (
                      <tr className="bg-white dark:bg-gray-900 dark:border-gray-700 text-center">
                        <td className="py-4 px-6 font-medium text-gray-600 whitespace-nowrap dark:text-white">
                          {test.created_at}
                        </td>
                        <td className="py-4 px-6 font-medium text-gray-600 whitespace-nowrap dark:text-white">
                          {test.oxygenLevel} %
                        </td>
                        <td className="py-4 px-6 font-medium text-gray-600 whitespace-nowrap dark:text-white">
                          {test.sugarLevel} %
                        </td>
                        <td className="py-4 px-6 font-medium text-gray-600 whitespace-nowrap dark:text-white">
                          {test.fatLevel} %
                        </td>
                        <td className="py-4 px-6 font-medium text-gray-600 whitespace-nowrap dark:text-white">
                          No disponible
                        </td>
                      </tr>
                    );
                  })}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      ) : (
        "Elementos por cargar"
      )}
    </main>
  );
};

export default Patient;
