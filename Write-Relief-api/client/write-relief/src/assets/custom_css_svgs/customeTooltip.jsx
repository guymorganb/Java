import { chakra } from '@chakra-ui/react';
export function CustomTooltip({ children }) {
    return (
      <chakra.span
        className="tooltip"
        position="absolute"
        top="0"
        fontSize="14px"
        bg="white"
        color="black" // Adjust color to be visible on white background
        p="5px 8px"
        borderRadius="5px"
        boxShadow="0 10px 10px rgba(0, 0, 0, 0.4)"
        opacity="0"
        pointerEvents="none"
        transition="all 0.3s cubic-bezier(0.68, -0.55, 0.265, 1.55)"
        _before={{
          content: `""`,
          position: "absolute",
          height: "8px",
          width: "8px",
          bg: "white",
          bottom: "-3px",
          left: "50%",
          transform: "translate(-50%) rotate(45deg)",
          transition: "all 0.3s cubic-bezier(0.8, -0.55, 0.265, 1.55)",
        }}
        whiteSpace="nowrap" // Ensures text is on a single line
        textAlign="center" // Centers the text
        width="auto" // Adjust width as needed, 'auto' might work but you can set a specific width
        left="50%" // Center tooltip horizontally relative to the parent
        transform="translateX(-50%)" // Adjust horizontal position to truly center the tooltip
      >
        {children}
      </chakra.span>
    );
  }