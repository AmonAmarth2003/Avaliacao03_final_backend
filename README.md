POST Person (Mapping:"/person"):
{
    "name" : "João",
    "contact" : "5548988888888",
    "gender" : "Male"
}

Informações:
- name: Deve conter no mínimo 4 caracteres.
- contact: É string e possui uma estrutura fixa de seguinte ordem:
  00 (Pode ou não conter);
  55 (obrigatório);
  DDD (qualquer DDD valido no país);
  9 (caso seja móvel);
  8 (dígitos finais); 
- gender: Somente aceito "Male" ou "Female";

----

POST Pacient (Mapping:"/paciente"):
{
    "id" : "0866f4d9-18b9-4b9e-8c69-ec2b75e867d8",
    "medical_history" : "O paciente relata que as dores começaram após um esforço físico intenso ao carregar caixas pesadas no trabalho. Refere que a dor é de intensidade moderada e melhora parcialmente com repouso e uso de analgésicos comuns. Negou irradiação para as pernas, formigamentos ou perda de força."
}

Informações:
- id: UUID de pessoa para realizar vinculo.
- medical_history : Informações gerais de histórico médico e alergias.

----

POST Doctor (Mapping:"/doctor"):
{
    id : "79ced6b1-7365-4329-b296-eb6de62a6957",
    specialization : "Neurocirurgião"
}

Infomações:
- id: UUID de pessoa para realizar vinculo.
- specialization : Especialização médica.

----

POST Appointment (Mapping:"/appointment"):

{
    "date" : "10/22/2025"
    "doctor_id" : "b2f4dc74-10f5-4d58-ab6e-01d3040ca15a",
    "patient_id" : "8804e263-16b5-419b-9a17-4af201ed243a"
}

Infomações:
- date: Data da consulta, quando a mesma será realizada;
  "mês/dia/ano"
- doctor_id: UUID do médico.
- pacient_id: UUID do paciente (UUID de Pacient e Doctor não são os mesmos de Person).

----