import React from 'react';
import { useColorMode, Button, Icon } from '@chakra-ui/react';
import { FaSun, FaMoon } from 'react-icons/fa';

export const ThemeToggleButton = () => {
  const { colorMode, toggleColorMode } = useColorMode();
  const handleClick = () => {
    console.log("Toggling color mode"); // Check if this logs when you click the button
    toggleColorMode();
    console.log(localStorage.getItem("chakra-ui-color-mode"));
  };
  return (
    <Button onClick={handleClick}>
      {colorMode === 'light' ? <Icon as={FaMoon} /> : <Icon as={FaSun} />}
    </Button>
  );
};

