insert into apl_test.tab_produtor_rural (id,                                     inscricao, nome,                  dt_cadastro,  area_propriedade)
                                 values ('eb5cf44d-8596-40b8-ac3e-3a44d9747264', 987654321, 'Chácara Milho Verde', '2020-09-23', 12);

insert into apl_test.tab_produto (id,                                     nome)
                          values ('5dc50945-5c2d-4cea-b058-fb60954c0457', 'Soja' ),
                                 ('57eb37d9-9c0b-4197-b0e5-1ce4ecda7470', 'Milho');

insert into apl_test.tab_producao (id, id_produtor_rural, id_produto, quantidade, dt_cadastro)
                          values  ('2d188d35-9fb7-41ee-969e-936326488bed', 'eb5cf44d-8596-40b8-ac3e-3a44d9747264', '5dc50945-5c2d-4cea-b058-fb60954c0457', 10,         '2020-09-01'),
                                  ('0f420b07-1827-490e-8c9e-95cae95ff0de', 'eb5cf44d-8596-40b8-ac3e-3a44d9747264', '57eb37d9-9c0b-4197-b0e5-1ce4ecda7470', 20,         '2020-09-02'),
                                  ('a466d180-8790-4d68-9778-db0792dd795f', 'eb5cf44d-8596-40b8-ac3e-3a44d9747264', '5dc50945-5c2d-4cea-b058-fb60954c0457', 30,         '2020-09-03'),
                                  ('92f58d24-e389-48bf-97b2-f588b0c4dc5e', 'eb5cf44d-8596-40b8-ac3e-3a44d9747264', '57eb37d9-9c0b-4197-b0e5-1ce4ecda7470', 40,         '2020-09-04');
