ALTER TABLE paciente
ADD COLUMN cpf VARCHAR(14); -- Ou outro tamanho apropriado

ALTER TABLE paciente
DROP COLUMN sexo;