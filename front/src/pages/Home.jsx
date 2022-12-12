import { useState, useEffect } from "react";
import AllPatientsTable from "../components/AllPatientsTable";

const Home = () => {
  const [addPatient, setAddPattient] = useState(false);

  const newPattientHandler = () => {
    setAddPattient((prev) => !prev);
  };
  return (
    <>
      <h1 className="my-12">Todos los pacientes</h1>
      <div className="flex items-center my-8">
        <button onClick={newPattientHandler}>+ Agregar paciente</button>
        {addPatient
          ? true && (
              <>
                <div className="mx-6 flex gap-4">
                  <input placeholder="Nombre completo" />
                  <input placeholder="Email" />
                </div>
                <button>Confirmar</button>
              </>
            )
          : null}
      </div>
      <AllPatientsTable />
    </>
  );
};

export default Home;
