-- V2: Migrations para adicionar a coluna de Rank

ALTER TABLE tb_ninja
ADD COLUMN rank VARCHAR(255);